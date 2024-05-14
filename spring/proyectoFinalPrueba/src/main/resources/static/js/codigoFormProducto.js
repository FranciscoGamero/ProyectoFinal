	let formArma = document.getElementById('formularioArma');
	let formEquip = document.getElementById('formularioEquipamiento');
	let tipoProducto = document.getElementById('tipoProducto'); 
	
	tipoProducto.addEventListener("change", mostrarForm);
	
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