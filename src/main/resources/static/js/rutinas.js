/*
 * Esta funcion muestra los datos de la tarjeta seleccionada en un Modal
 */

document.onreadystatechange = function () {
    if (document.readyState == "interactive") {
        const exampleModal = document.getElementById('exampleModal');
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
            })
        }
    }
}