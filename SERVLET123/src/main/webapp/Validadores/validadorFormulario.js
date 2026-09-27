function validar(){
    let titulo = FormularioLivro.titulo.value;
    let autor = FormularioLivro.autor.value;
    let isbn = FormularioLivro.isbn.value;
    let ano_publicacao = FormularioLivro.ano_publicacao.value;
    let disponivel = FormularioLivro.disponivel.value;

    if (titulo === ""){
        alert('Preencha o campo nome!');
        FormularioLivro.titulo.focus();
        return false;
    }else if(autor === ''){
        alert('Preencha o campo do autor');
        FormularioLivro.autor.focus();
        return false;
    }else if (isbn === null || isbn.length != 13){
        alert('Preencha o campo do isbn com 13 digitos');
        FormularioLivro.isbn.focus();
        return false;
    }else if (ano_publicacao === "" || ano_publicacao === null){
        alert('Preencha o campo do ano da publicação do livro');
        FormularioLivro.ano_publicacao.focus();
        return false;
    }else if (disponivel !== "S" && disponivel !== "s" && disponivel !== "N" && disponivel !== "n"){
        alert('Preencha o campo: Disponivel com (S/N)');
        FormularioLivro.disponivel.focus();
        return false;
    }else{
        document.forms["FormularioLivro"].submit();
    }
}