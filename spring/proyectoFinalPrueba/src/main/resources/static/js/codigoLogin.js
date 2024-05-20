document.addEventListener('DOMContentLoaded', function() {
    let formulario = document.getElementById('login');

    document.getElementById('vercontrasenia').addEventListener('mouseover', verContrasenia);
    document.getElementById('vercontrasenia').addEventListener('mouseout', esconderContrasenia);

    function verContrasenia(elEvento) {
        this.previousElementSibling.type = 'text';
    }

    function esconderContrasenia(elEvento) {
        this.previousElementSibling.type = 'password';
    }

    formulario.addEventListener('submit', validarFormulario);

    function validarFormulario(elEvento) {
        elEvento.preventDefault();

        let formularioValido = true;

        if (formulario.username.value.trim() === '') {
            mostrarError('error-username');
            formularioValido = false;
        } else {
            ocultarError('error-username');
        }

        if (formulario.password.value.trim() === '') {
            mostrarError('error-password');
            formularioValido = false;
        } else {
            ocultarError('error-password');
        }

        if (formularioValido) {
            formulario.submit();
        }
    }

    function mostrarError(id) {
        let elementoError = document.getElementById(id);
        elementoError.classList.remove('oculto');
        let campoId = elementoError.getAttribute('for');
        let campo = document.getElementById(campoId);
        if (campo != null) {
            campo.classList.add('campo-invalido');
        }
    }
    
    function ocultarError(id) {
        let elementoError = document.getElementById(id);
        elementoError.classList.add('oculto');
        let campoId = elementoError.getAttribute('for');
        let campo = document.getElementById(campoId);
        if (campo != null) {
            campo.classList.remove('campo-invalido');
        }
    }
});