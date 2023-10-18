fetch("http://localhost:8080/api/lista").then((response) => response.json().then(response =>{
    let resp = JSON.parse(JSON.stringify(response))
    let tabela = document.getElementById("tabela")
    for(let i = 0; i < resp.length; i++)
    {
        let rowCount = tabela.rows.length;
            let row = tabela.insertRow(rowCount);
            row.insertCell(0).innerHTML = resp[i].nome
            row.insertCell(1).innerHTML = resp[i].ip
            row.insertCell(2).innerHTML = resp[i].mac
            row.insertCell(3).innerHTML = resp[i].descricao
            row.insertCell(4).innerHTML = resp[i].localizacao
            row.insertCell(5).innerHTML = resp[i].tipo
    }
}))

document.getElementById("voltar").addEventListener("click", function () {
    location.href = "/"
})