/*
 * Esta funcion muestra los datos de la tarjeta seleccionada en un Modal
 */

document.onreadystatechange = function () {
    if (document.readyState == "interactive") {
        const exampleModal = document.getElementById('exampleModal');
        const offcanvasRight = document.getElementById('offcanvasRight');

        if (exampleModal) {
            exampleModal.addEventListener('show.bs.modal', event => {
                const button = event.relatedTarget;
                const nombre = button.getAttribute('data-nombre');
                const imagen = button.getAttribute('data-imagen');
                const descripcion = button.getAttribute('data-descripcion');

                const modalTitle = exampleModal.querySelector('.modal-title');
//                const modalBodyInput = exampleModal.querySelector('.modal-body p')
                const modalImage = exampleModal.querySelector('#modal-image');
                const modalDescripcion = exampleModal.querySelector('#modal-body-descripcion');

                modalTitle.textContent = nombre;
                modalImage.src = imagen;
                modalDescripcion.textContent = descripcion;
            });
        }

    }


}

function addCart(formulario) {
    var valor = formulario.elements[0].value;
    var existencias = formulario.elements[0].value;
    if (existencias > 0) {
        var url = "/carrito/agregar/" + valor;
        $("#resultsBlock").load(url);
    }
}

;