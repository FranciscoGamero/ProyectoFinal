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
		
		
		
		
		