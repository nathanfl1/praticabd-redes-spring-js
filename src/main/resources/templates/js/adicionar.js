document.getElementById("enviar").addEventListener("click", function () {

    if (document.getElementById("nome").value != "" &&
        document.getElementById("mac").value != "" &&
        document.getElementById("ip").value != "" &&
        document.getElementById("descricao").value != "" &&
        document.getElementById("localizacao").value != "") {

        if (IpAndMacValid()) {
            let inputTipo = document.getElementById("tipo")
            fetch("http://localhost:8080/api/cadastrar", {
                method: "POST",
                body: JSON.stringify({
                    nome: document.getElementById("nome").value,
                    mac: document.getElementById("mac").value,
                    ip: document.getElementById("ip").value,
                    descricao: document.getElementById("descricao").value,
                    localizacao: document.getElementById("localizacao").value,
                    tipo: inputTipo.options[inputTipo.selectedIndex].value
                })
            }).then((response) => {
                if(response.status == 400)
                {
                    document.getElementById("mensagem").hidden = true;
                    document.getElementById("mensagem2").hidden = true;
                    document.getElementById("mensagem3").hidden = false;
                }
            })
        }
        else {
            document.getElementById("mensagem").hidden = true;
            document.getElementById("mensagem2").hidden = false;
            document.getElementById("mensagem3").hidden = true;
        }
    }
    else {
        document.getElementById("mensagem").hidden = false;
        document.getElementById("mensagem2").hidden = true;
        document.getElementById("mensagem3").hidden = true;
    }
})



function IpAndMacValid() {
    let ip = document.getElementById("ip");
    let mac = document.getElementById("mac");
    let numeros = ip.value.split(".")

    if (numeros.length != 4)
        return false
    for (const numero of numeros) {
        let n = parseInt(numero)
        if (!isNaN(n)) {
            if (n > 255 || n < 0) {
                return false;
            }
        }
        else
            return false;
    }

    let numerosMac = mac.value.split(":")
    if (numerosMac.length != 6)
        return false

    for (const numero of numerosMac) {
        for (let i = 0; i < numero.length; i++) {
            if (numero.charAt(i) > 'F' || numero.charAt(i) < '0')
                return false;
        }
    }
    return true;

}