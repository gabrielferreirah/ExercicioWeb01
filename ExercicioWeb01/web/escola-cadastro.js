function validarFormulario() {
	if (validarCampoNome==false || validar) {

	}
event.preventDefault();
}

function validarCampoNome() {
    var nome =document.getElementById("campo-nome").value;
    var quantidadeCaracteres = nome.length;

    apagarElementoSeExiste("span-campo-nome-menor-7");
    apagarElementoSeExiste("span-campo-nome-maior-100");

    if (quantidadeCaracteres < 7) {
        gerarSpan("span-campo-menor-7", "Nome deve conter no mínimo 7 (sete) caracteres", "div-campo-nome");
        adicionarClasse("campo-nome", "border-danger");
        apagarClasse("campo-nome", "border-success");
        return false;
    }else if (quantidadeCaracteres > 100) {
        gerarSpan("span-campo-nome-maior-100", "Nome deve conter no máximo 100 caracteres", "div-campo-nome");
        adicionarClasse("campo-nome", "border-success");
        apagarClasse("campo-nome", "border-success");
        return false;
    } else {
        adicionarClasse("campo-nome", "border-success");
        apagarClasse("campo-nome", "border-danger");
        return true;
    }
}

function validarCampoNota1() {
    apagarElementoSeExiste("span-campo-quantidade-menor-zero");
    var nota1 = parseFloat(document.getElementById("campo-nota1").value);
    if (nota1 < 0) {
    gerarSpan("span-campo-quantidade-menor-zero", "Quantidade deve ser maior ou igual a zero", "div campo-nota1");
    adicionarClasse("campo-nota1", "border-danger");
    apagarClasse("campo-quantidade", "border-success");
    return false;
    } else {
    adicionarClasse("campo-quantidade", "border-success");
    apagarClasse("campo-quantidade", "border-danger");
    return true;
    }
}

function validarCampoNota2() {
    apagarElementoSeExiste("span-campo-quantidade-menor-zero");
    var nota2 = parseFloat(document.getElementById("campo-nota2").value);
    if (nota2 < 0) {
    gerarSpan("span-campo-quantidade-menor-zero", "Quantidade deve ser maior ou igual a zero", "div campo-nota2");
    adicionarClasse("campo-nota2", "border-danger");
    apagarClasse("campo-quantidade", "border-success");
    return false;
    } else {
    adicionarClasse("campo-quantidade", "border-success");
    apagarClasse("campo-quantidade", "border-danger");
    return true;
    }
}

function validarCampoNota3() {
    apagarElementoSeExiste("span-campo-quantidade-menor-zero");
    var nota3 = parseFloat(document.getElementById("campo-nota3").value);
    if (nota3 < 0) {
    gerarSpan("span-campo-quantidade-menor-zero", "Quantidade deve ser maior ou igual a zero", "div campo-nota3");
    adicionarClasse("campo-nota3", "border-danger");
    apagarClasse("campo-quantidade", "border-success");
    return false;
    } else {
    adicionarClasse("campo-quantidade", "border-success");
    apagarClasse("campo-quantidade", "border-danger");
    return true;
    }
}

function apagarElementoSeExiste(id) {
    if (document.contains(document.getElementById(id))) {
       document.getElementById.remove(); 
    }
}

function apagarClasse(id,classeCor) {
    document.getElementById(id).classList.remove(classeCor);
}

function gerarSpan(id, texto,idPai) {
    var span = document.createElement("span");
    span.id = id;
    span.textContent = texto;
    span.classList.add("text-danger");
    span.classList.add("font-weight-bold");
    document.getElementById(idPai.appendChild(span));
}