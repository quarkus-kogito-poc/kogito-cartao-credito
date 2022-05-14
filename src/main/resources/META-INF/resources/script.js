const source = new EventSource("/compras/stream");
source.onmessage = event => {
  const request = JSON.parse(event.data)
  const timeElapsed = Date.now();
  const today = new Date(timeElapsed);
  console.log('request: ' + request);

  if (request.data.validacao) {
    $('#entries > tbody:first').append(`
      <tr>
        <td>${request.id}</td>
        <td>${today.toISOString()}</td>
        <td>${request.data.compra.cpf}</td>
        <td>${request.data.compra.local}</td>
        <td>${request.data.compra.valor}</td>
        <td style="background-color:#EE2435">FRAUDE</td>
      </tr>
    `);
  } else {
    $('#entries > tbody:first').append(`
      <tr>
        <td>${request.id}</td>
        <td>${today.toISOString()}</td>
        <td>${request.data.compra.cpf}</td>
        <td>${request.data.compra.local}</td>
        <td>${request.data.compra.valor}</td>
        <td style="background-color:#3E9C35">APROVADA</td>
      </tr>
    `);
  }
  
  
};