/**
 * Array de Estados
 */
var estados = [
	{ "id": 1, "estado": "SP"},
	{ "id": 2, "estado": "RJ"},
	{ "id": 3, "estado": "RS"},
	{ "id": 4, "estado": "RN"},
	{ "id": 5, "estado": "SC"}
];

//Array de Cidades
var cidades = [
	{ "id": 1, "idestado": 1, "cidade": "CAMPINAS"},
	{ "id": 2, "idestado": 1, "cidade": "SOROCABA"},
	{ "id": 3, "idestado": 2, "cidade": "NITEROI"},
	{ "id": 4, "idestado": 4, "cidade": "NATAL"},
	{ "id": 5, "idestado": 3, "cidade": "PORTO ALEGRE"},
	{ "id": 6, "idestado": 1, "cidade": "SÃO PAULO"},
	{ "id": 7, "idestado": 5, "cidade": "ESPÍRITO SANTO"},
	{ "id": 8, "idestado": 1, "cidade": "SANTOS"}
];

$(document).ready(function(){
	//preenche o elemento <select id="estado"> com os estados
	$.each(estados, function(i, estado){
		$("#estado").append($("<option>", {
			value: estado.id,
			text: estado.estado
		}));
	});
	
	//definição do evento de mudança de posição da lista de estados
	$("#estado").change(function(){
		var idestado = $(this).val();
		
		var cidadesFiltradas = $.grep(cidades, function(e){
			return e.idestado == idestado;
		});
		
		$("#cidade").html("<option>Selecione</option>");
		$.each(cidadesFiltradas, function(i, cidade){
			$("#cidade").append($("<option>", {
				value: cidade.id,
				text: cidade.cidade
			}));
		});
	});
});