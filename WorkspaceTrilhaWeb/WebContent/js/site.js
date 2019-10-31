function validaFaleConosco() {
    if (document.frmfaleconosco.txtnome.value == "") {
        alert("Preencha o campo Nome.");
        document.frmfaleconosco.txtnome.focus();
        return false;
    }
    if (document.frmfaleconosco.txtfone.value == "") {
        alert("Preencha o campo Telefone.");
        document.frmfaleconosco.txtfone.focus();
        return false;
    }
    if (document.frmfaleconosco.txtemail.value == "") {
        alert("Preencha o campo E-mail.");
        document.frmfaleconosco.txtemail.focus();
        return false;
    }
    if (document.frmfaleconosco.selmotivo.value == "") {
        alert("Preencha o campo Motivo.");
        document.frmfaleconosco.selmotivo.focus();
        return false;
    }
    if (document.frmfaleconosco.selmotivo.value === "PR" && !document.frmfaleconosco.selproduto.value) {
        alert("Preencha o produto.");
        document.frmfaleconosco.selproduto.focus();
        return false;
    }
    if (document.frmfaleconosco.txacomentario.value == "") {
        alert("Preencha o campo Comentário.");
        document.frmfaleconosco.txacomentario.focus();
        return false;
    }
    return true;
}

function verificaMotivo(motivo) {
    const elemento = document.getElementById('opcaoProduto');

    if (motivo === "PR") {
        const select = document.createElement('select');
        select.setAttribute('name', 'selproduto');

        let option = document.createElement('option');
        option.setAttribute('value', '');
        let texto = document.createTextNode('Escolha');
        option.appendChild(texto);

        select.appendChild(option);

        option = document.createElement('option');
        option.setAttribute('value', 'FR')
        texto = document.createTextNode('Freezer');
        option.appendChild(texto)
        select.appendChild(option);

        option = document.createElement('option');
        option.setAttribute('value', 'GE')
        texto = document.createTextNode('Geladeira');
        option.appendChild(texto)
        select.appendChild(option);

        elemento.appendChild(select);
    } else {
        if (elemento.firstChild) {
            elemento.removeChild(elemento.firstChild);
        }
    }
}