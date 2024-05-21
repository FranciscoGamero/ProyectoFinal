document.addEventListener('DOMContentLoaded', function() {
    let formulario = document.getElementById('registro');

    document.getElementById('vercontrasenia').addEventListener('mouseover', verContrasenia);
    document.getElementById('vercontrasenia').addEventListener('mouseout', esconderContrasenia);

    function verContrasenia(elEvento) {
        this.previousElementSibling.type = 'text';
    }

    function esconderContrasenia(elEvento) {
        this.previousElementSibling.type = 'password';
    }

    function comprobarDNI() {
        let dni = document.getElementById('dni').value;
        let numerosDNI = dni.substring(0, 8);
        let letrasDNI = 'TRWAGMYFPDXBNJZSQVHLCKE';
        let letraCalculada = letrasDNI.charAt(numerosDNI % 23);
        return dni === numerosDNI.concat(letraCalculada);
    }

    function comprobarCorreo() {
        let correo = document.getElementById('exampleInputEmail').value;
        return correo.match('^[A-Za-z0-9]+@[A-Za-z0-9]+\.[A-Z|a-z]{2,}$');
    }

    function comprobarContrasena() {
        let contrasenia = document.getElementById('contrasenia').value;
        let contrConf = document.getElementById('contrasenia_confirmacion').value;
        return contrasenia.match("^[A-Za-z0-9]{2,}$") && contrasenia === contrConf;
    }

    formulario.addEventListener('submit', validarFormulario);

    function validarFormulario(elEvento) {
        elEvento.preventDefault();

        let formularioValido = true;

        if (formulario.nombre.value.trim() === '') {
            mostrarError('error-nombre');
            formularioValido = false;
        } else {
            ocultarError('error-nombre');
        }

        if (formulario.apellidos.value.trim() === '') {
            mostrarError('error-apellido');
            formularioValido = false;
        } else {
            ocultarError('error-apellido');
        }
        if (formulario.direccion.value.trim() === '') {
            mostrarError('error-direccion');
            formularioValido = false;
        } else {
            ocultarError('error-direccion');
        }
        if (formulario.usuario.value.trim() === '') {
            mostrarError('error-usuario');
            formularioValido = false;
        } else {
            ocultarError('error-usuario');
        }

        if (!comprobarDNI()) {
            mostrarError('error-dni');
            formularioValido = false;
        } else {
            ocultarError('error-dni');
        }

        if (!comprobarCorreo()) {
            mostrarError('error-email');
            formularioValido = false;
        } else {
            ocultarError('error-email');
        }

        if (!comprobarContrasena()) {
            mostrarError('error-contrasenia');
            formularioValido = false;
        } else {
            ocultarError('error-contrasenia');
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