package com.proyectoANKA.DesarrolloWeb.controller;

import com.proyectoANKA.DesarrolloWeb.domain.Categoria;
import com.proyectoANKA.DesarrolloWeb.services.CategoriaServices;
import com.proyectoANKA.DesarrolloWeb.domain.Producto;
import com.proyectoANKA.DesarrolloWeb.services.ProductoServices;
import com.proyectoANKA.DesarrolloWeb.services.FirebaseStorageService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/producto")

public class ProductoController {

    @Autowired
    private ProductoServices productoService;

    @Autowired
    private CategoriaServices categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());

        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);

        return "/index";
    }

    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categoria categoria) {

        ArrayList<Producto> producto = new ArrayList();
        for (Producto producto1 : categoriaService.getCategoria(categoria).getProductos()) {

            if (producto1.isActivo()) {
                producto.add(producto1);
            }

        }

        var productos = producto;

        var categorias = categoriaService.getCategorias(true);

        model.addAttribute("categorias", categorias);

        model.addAttribute("productos", productos);

        if (categoria.getIdCategoria() == 1) {
            return "/producto/listadoBisuteria";
        } else if (categoria.getIdCategoria() == 2) {
            return "/producto/listadoCeramica";
        } else {
            return "/producto/listadoArte";
        }

    }

    @GetMapping("/listadoCRUD/{idCategoria}")
    public String listadoCRUD(Model model, Categoria categoria) {

        var productos = categoriaService.getCategoria(categoria)
                .getProductos();
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());

        return "/producto/listadoCRUD";

    }

    @GetMapping("/listadoCRUD")
    public String listadoCrud(Model model) {

        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);

        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalProductos", productos.size());

        return "/producto/listadoCRUD";
    }

    

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Producto producto, @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {

            if (producto.getCategoria().getIdCategoria() == 1) {
                productoService.save(producto);
                String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "bisuteria", producto.getIdProducto());

                producto.setRutaImagen(rutaImagen);
            } else if (producto.getCategoria().getIdCategoria() == 2) {
                productoService.save(producto);
                String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "ceramica", producto.getIdProducto());

                producto.setRutaImagen(rutaImagen);
            } else {
                productoService.save(producto);
                String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "arte", producto.getIdProducto());

                producto.setRutaImagen(rutaImagen);
            }

        }
        productoService.save(producto);

        return "redirect:/producto/listadoCRUD";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String eliminar(Producto producto) {

        productoService.delete(producto);

        return "redirect:/producto/listadoCRUD";

    }

    @GetMapping("/modificar/{idProducto}")
    public String modificar(Producto producto, Model model) {

        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);

        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/producto/modifica";

    }

}
