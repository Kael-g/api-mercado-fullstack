const form = document.getElementById("cadastro");

form.addEventListener("submit", event =>{
    event.preventDefault();

    const formData = new FormData(form);
    const data = Object.fromEntries(formData);

    fetch("http://localhost:8080/produtos",{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(res => res.json()).then(data => console.log(data)).catch(error => console.log(error));
});

function mensagem(){
    alert("Produto cadastrado com sucesso!")
    window.location.reload(true);
}

fetch("http://localhost:8080/produtos").then((data)=>{
    return data.json();
}).then((todosProdutos) => {
    let data1 = "";
    todosProdutos.map((values) => {
        data1 += `
        <tbody>
            <tr>
                <th scope="row">${values.id}</th>
                <td>${values.nome}</td>
                <td>${values.descricao}</td>
                <td>${values.valor}</td>
            </tr>
        </tbody>
        `
    })

    document.getElementById("produtoDados").innerHTML = data1;
    console.log(todosProdutos);
})