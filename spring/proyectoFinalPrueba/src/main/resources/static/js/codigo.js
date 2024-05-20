		let arma = document.getElementById("botonArma");
		let equipamiento = document.getElementById("botonEquipamiento");
		let todos = document.getElementById("botonProductos");
		let tablaArmas = document.getElementById('tablaArmas');
		let tablaEquipamiento = document.getElementById('tablaEquipamiento');
		let tablaTodos = document.getElementById('tablaProductos');
		
      	let formArma = document.getElementById('formularioArma');
        let formEquip = document.getElementById('formularioEquipamiento');
        let tipoProducto = document.getElementById('tipoProducto');



		arma.addEventListener("click", mostrarTablaArmas);
		equipamiento.addEventListener("click", mostrarTablaEquipamiento);
		todos.addEventListener("click", mostrarTablaTodos);
		
		tipoProducto.addEventListener("change", mostrarForm);


		function mostrarTablaTodos() {
			tablaTodos.classList.remove('d-none');
			tablaArmas.classList.add('d-none');
			tablaEquipamiento.classList.add('d-none');
		}
		function mostrarTablaArmas() {
			tablaArmas.classList.remove('d-none');
			tablaTodos.classList.add('d-none');
			tablaEquipamiento.classList.add('d-none');
		}

		function mostrarTablaEquipamiento() {
			tablaEquipamiento.classList.remove('d-none');
			tablaTodos.classList.add('d-none');
			tablaArmas.classList.add('d-none');

		}
		function onPageLoad() {

			const urlParams = new URLSearchParams(window.location.search);
			const mostrarTablaParam = urlParams.get('mostrarTabla');

			if (mostrarTablaParam === "arma") {
				mostrarTablaArmas();
			} else if (mostrarTablaParam === "equip") {
				mostrarTablaEquipamiento();
			}
		}

		function mostrarForm() {
            let eleccion = tipoProducto.value;

            if (eleccion === '1') {
                formArma.classList.remove('d-none');
                formEquip.classList.add('d-none');
            } else if (eleccion === '2') {
                formEquip.classList.remove('d-none');
                formArma.classList.add('d-none');
            }
        }
		window.onload = onPageLoad;
		
	document.getElementById('myForm').addEventListener('submit', function(event) {
		var isValid = true;
		var errorMessage = '';
	
		var imagen = document.getElementById('imagen').value;
		if (!imagen) {
			isValid = false;
			errorMessage += 'El campo Imagen es obligatorio.\n';
		}
	
		var precioHora = document.getElementById('precioHora').value;
		if (!precioHora) {
			isValid = false;
			errorMessage += 'El campo Precio por hora es obligatorio.\n';
		} else if (isNaN(precioHora) || precioHora <= 0) {
			isValid = false;
			errorMessage += 'El campo Precio por hora debe ser un número positivo.\n';
		}
	
		var tipoGalerias = document.getElementById('tipoGalerias').value;
		if (!tipoGalerias) {
			isValid = false;
			errorMessage += 'Debe seleccionar un tipo de galería.\n';
		}
	
		var cantPersonas = document.getElementById('cantPersonas').value;
		if (!cantPersonas) {
			isValid = false;
			errorMessage += 'El campo Capacidad de personas es obligatorio.\n';
		} else if (isNaN(cantPersonas) || cantPersonas <= 0) {
			isValid = false;
			errorMessage += 'El campo Capacidad de personas debe ser un número positivo.\n';
		}
	
		if (!isValid) {
			alert(errorMessage);
			event.preventDefault();
		}
	});

	document.getElementById('formAgregarProducto').addEventListener('submit', function(event) {
		var isValid = true;
		var errorMessage = '';
	
		var nombre = document.getElementById('nombre').value;
		var descripcion = document.getElementById('descripcion').value;
		var marca = document.getElementById('marca').value;
		var imagen = document.getElementById('imagen').value;
		var precio = document.getElementById('precio').value;
	
		if (!nombre) {
			isValid = false;
			errorMessage += 'El campo Nombre es obligatorio.\n';
		}
	
		if (!descripcion) {
			isValid = false;
			errorMessage += 'El campo Descripción es obligatorio.\n';
		}
	
		if (!marca) {
			isValid = false;
			errorMessage += 'El campo Marca es obligatorio.\n';
		}
	
		if (!imagen) {
			isValid = false;
			errorMessage += 'El campo Imagen es obligatorio.\n';
		}
	
		if (!precio || isNaN(precio) || precio <= 0) {
			isValid = false;
			errorMessage += 'El campo Precio es obligatorio y debe ser un número positivo.\n';
		}
	
		var tipoProducto = document.getElementById('tipoProducto').value;
		if (tipoProducto == '1') {
			var capacidadCargador = document.getElementById('capacidadCargador').value;
			if (!capacidadCargador || isNaN(capacidadCargador) || capacidadCargador <= 0) {
				isValid = false;
				errorMessage += 'El campo Capacidad cargador es obligatorio y debe ser un número positivo.\n';
			}
		} else if (tipoProducto == '2') {
			var tallaChecked = document.querySelector('#formularioEquipamiento input[name="talla"]:checked');
			if (!tallaChecked) {
				isValid = false;
				errorMessage += 'Debe seleccionar al menos una Talla para el equipamiento.\n';
			}
			var color = document.getElementById('color').value;
			if (!color) {
				isValid = false;
				errorMessage += 'El campo Color es obligatorio.\n';
			}
		}
	
		if (!isValid) {
			alert(errorMessage);
			event.preventDefault();
		}
	});

	document.getElementById('formNuevoTipoGaleria').addEventListener('submit', function(event) {
		var isValid = true;
		var errorMessage = '';
	
		// Validar campos obligatorios
		var nombre = document.getElementById('nombre').value;
		var precioAgregado = document.getElementById('precioAgregado').value;
	
		if (!nombre) {
			isValid = false;
			errorMessage += 'El campo Nombre es obligatorio.\n';
		}
	
		if (!precioAgregado || isNaN(precioAgregado) || precioAgregado < 0) {
			isValid = false;
			errorMessage += 'El campo Precio añadido es obligatorio y debe ser un número positivo.\n';
		}
	
		// Mostrar mensaje de error si hay errores
		if (!isValid) {
			alert(errorMessage);
			event.preventDefault(); // Evitar el envío del formulario
		}
	});
	document.getElementById('formEditarEquipamiento').addEventListener('submit', function(event) {
		var isValid = true;
		var errorMessage = '';
	
		// Validar campos obligatorios
		var nombre = document.getElementById('nombre').value;
		var descripcion = document.getElementById('descripcion').value;
		var marca = document.getElementById('marca').value;
		var imagen = document.getElementById('imagen').value;
		var precio = document.querySelector('[name="precio"]').value;
		var tallas = document.querySelectorAll('input[name="talla"]:checked');
		var color = document.getElementById('color').value;
	
		if (!nombre) {
			isValid = false;
			errorMessage += 'El campo Nombre es obligatorio.\n';
		}
	
		if (!descripcion) {
			isValid = false;
			errorMessage += 'El campo Descripción es obligatorio.\n';
		}
	
		if (!marca) {
			isValid = false;
			errorMessage += 'El campo Marca es obligatorio.\n';
		}
	
		if (!imagen) {
			isValid = false;
			errorMessage += 'El campo Imagen es obligatorio.\n';
		}
	
		if (!precio || isNaN(precio) || precio <= 0) {
			isValid = false;
			errorMessage += 'El campo Precio es obligatorio y debe ser un número positivo.\n';
		}
	
		// Validar tallas si es necesario
		if (tallas.length === 0) {
			isValid = false;
			errorMessage += 'Debe seleccionar al menos una talla.\n';
		}
	
		// Validar color
		if (!color) {
			isValid = false;
			errorMessage += 'Debe ingresar un color.\n';
		}
	
		// Mostrar mensaje de error si hay errores
		if (!isValid) {
			alert(errorMessage);
			event.preventDefault(); // Evitar el envío del formulario
		}
	});

	document.getElementById('formEditarTipoGaleria').addEventListener('submit', function(event) {
		var isValid = true;
		var errorMessage = '';
	
		// Validar campos obligatorios
		var descripcion = document.getElementById('descripcion').value;
		var imagen = document.getElementById('imagen').value;
		var precioHora = document.querySelector('[name="precioHora"]').value;
		var tipoGalerias = document.getElementById('tipoGalerias').value;
		var cantPersonas = document.getElementById('cantPersonas').value;
	
		if (!descripcion) {
			isValid = false;
			errorMessage += 'El campo Descripción es obligatorio.\n';
		}
	
		if (!imagen) {
			isValid = false;
			errorMessage += 'El campo Imagen es obligatorio.\n';
		}
	
		if (!precioHora || isNaN(precioHora) || precioHora <= 0) {
			isValid = false;
			errorMessage += 'El campo Precio por hora es obligatorio y debe ser un número positivo.\n';
		}
	
		if (!tipoGalerias) {
			isValid = false;
			errorMessage += 'Debe seleccionar un Tipo de Galería.\n';
		}
	
		if (!cantPersonas || isNaN(cantPersonas) || cantPersonas <= 0) {
			isValid = false;
			errorMessage += 'El campo Capacidad de personas es obligatorio y debe ser un número positivo.\n';
		}
	
		// Mostrar mensaje de error si hay errores
		if (!isValid) {
			alert(errorMessage);
			event.preventDefault(); // Evitar el envío del formulario
		}
	});

	
document.getElementById('formEditarUsuario').addEventListener('submit', function(event) {
    var isValid = true;
    var errorMessage = '';

    // Validar campos obligatorios
    var nombre = document.getElementById('nombre').value;
    var apellidos = document.getElementById('apellidos').value;
    var dni = document.getElementById('dni').value;
    var direccion = document.getElementById('direccion').value;
    var email = document.getElementById('exampleInputEmail').value;
    var usuario = document.getElementById('usuario').value;

    if (!nombre) {
        isValid = false;
        errorMessage += 'El campo Nombre es obligatorio.\n';
    }

    if (!apellidos) {
        isValid = false;
        errorMessage += 'El campo Apellidos es obligatorio.\n';
    }

	let dniRegex = /^[0-9]{8}[A-Z]{1}$/;
    if (!dniRegex.test(dni)) {
        dniError.textContent = 'Por favor, introduce un DNI válido (8 dígitos seguidos de una letra mayúscula).';
        event.preventDefault();
        return;
    }

    if (!direccion) {
        isValid = false;
        errorMessage += 'El campo Dirección es obligatorio.\n';
    }

    if (!email) {
        isValid = false;
        errorMessage += 'El campo Correo electrónico es obligatorio.\n';
    } else if (!validateEmail(email)) {
        isValid = false;
        errorMessage += 'El correo electrónico no es válido.\n';
    }

    if (!usuario) {
        isValid = false;
        errorMessage += 'El campo Nombre de usuario es obligatorio.\n';
    }

    // Mostrar mensaje de error si hay errores
    if (!isValid) {
        alert(errorMessage);
        event.preventDefault(); // Evitar el envío del formulario
    }
});

// Función para validar el formato del correo electrónico
function validateEmail(email) {
    var re = '/^[^\s@]+@[^\s@]+\.[^\s@]+$/';
    return re.test(email);
}

document.getElementById('login').addEventListener('submit', function(event) {
	var isValid = true;
	var errorMessage = '';

	// Validar nombre de usuario
	var username = document.getElementById('username').value;
	if (!username) {
		isValid = false;
		errorMessage += 'Por favor, ingresa tu nombre de usuario.\n';
	}

	// Validar contraseña
	var password = document.getElementById('password').value;
	if (!password) {
		isValid = false;
		errorMessage += 'Por favor, ingresa tu contraseña.\n';
	}

	// Mostrar mensaje de error si hay errores
	if (!isValid) {
		alert(errorMessage);
		event.preventDefault(); // Evitar el envío del formulario
	}
});
	document.getElementById('registro').addEventListener('submit', function (event) {
    let telefonoError = document.getElementById('telefonoError');
    let dni = document.getElementById('dni').value;
    let dniError = document.getElementById('dniError');
    let correoElectronico = document.getElementById('correoElectronico').value;
    let correoElectronicoError = document.getElementById('correoElectronicoError');

    // Limpia el mensaje de error
    fechaNacimientoError.textContent = '';
    telefonoError.textContent = '';
    dniError.textContent = '';
    correoElectronicoError.textContent = '';

    if (!fechaNacimiento) {
        fechaNacimientoError.textContent = 'Por favor, introduce tu fecha de nacimiento.';
        event.preventDefault();
        return;
    }

    let fechaNacimientoDate = new Date(fechaNacimiento);
    let today = new Date();
    let edad = today.getFullYear() - fechaNacimientoDate.getFullYear();
    let monthDifference = today.getMonth() - fechaNacimientoDate.getMonth();
    let dayDifference = today.getDate() - fechaNacimientoDate.getDate();

    // Ajusta la edad si el mes o el día de cumpleaños no ha pasado todavía en el año actual
    if (monthDifference < 0 || (monthDifference === 0 && dayDifference < 0)) {
        edad--;
    }

    if (edad < 18) {
        fechaNacimientoError.textContent = 'Debes tener al menos 18 años para registrarte.';
        event.preventDefault();
    }

    let telefonoRegex = /^[0-9]{9}$/;
    if (!telefonoRegex.test(telefono)) {
        telefonoError.textContent = 'Por favor, introduce un número de teléfono válido de 9 dígitos.';
        event.preventDefault();
    }

    let dniRegex = /^[0-9]{8}[A-Z]{1}$/;
    if (!dniRegex.test(dni)) {
        dniError.textContent = 'Por favor, introduce un DNI válido (8 dígitos seguidos de una letra mayúscula).';
        event.preventDefault();
        return;
    }

    // Validación de correo electrónico
    let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(correoElectronico)) {
        correoElectronicoError.textContent = 'Por favor, introduce un correo electrónico válido.';
        event.preventDefault();
        return;
    }
});
		