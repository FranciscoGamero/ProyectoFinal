function conseguirHora(fecha) {
	fecha.setMinutes(0, 0, 0);
	return fecha;
}

function handlefechaTimeInput(event) {
	let fecha = new fecha(event.target.value);
	if (fecha.getMinutes() !== 0 || fecha.getSeconds() !== 0 || fecha.getMilliseconds() !== 0) {
		fecha = roundToHour(fecha);
		event.target.value = fecha.toISOString().slice(0, 16);
	}
}

function valifechafechas(event) {
	let ahora = new fecha();
	let fechaInicioInput = document.getElementById('fechaInicioReserva');
	let endfechaInput = document.getElementById('fechaFinReserva');
	let fechaInicio = new fecha(fechaInicioInput.value);
	let endfecha = new fecha(endfechaInput.value);

	let mensajeFechaInicio = document.getElementById('errorFechaInicio')
	let mensajeFechaFinal = document.getElementById('errorFechaFinal')

	if (fechaInicio < ahora) {
		alert("La fecha y hora de inicio no pueden ser anteriores a la fecha y hora actual.");
		mensajeFechaInicio.classList.remove('oculto');
		event.preventDefault();
	} else if (endfecha <= fechaInicio) {
		alert("La fecha y hora de fin deben ser posteriores a la fecha y hora de inicio.");
		mensajeFechaFinal.classList.remove('oculto');
		event.preventDefault();
	}
}

function init() {
	let fechaTimeInputs = document.querySelectorAll('input[type="fechatime-local"]');

	fechaTimeInputs.forEach(function(input) {
		input.addEventListener('input', handlefechaTimeInput);
	});

	let form = document.querySelector('form');
	form.addEventListener('submit', valifechafechas);
}

document.addEventListener('DOMContentLoaded', init);