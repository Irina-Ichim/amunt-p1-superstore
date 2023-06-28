
<script>

    export let info;
    let name="";
    let precio="";
    let descripcion="";
    let url="";


    let error = false;

    function validar() {
        if (info.name === "manu" ) {
            alert("lo pilla")
        } else {
            error=true;
        }
    }
</script>
<div>
    <h1>CREAR PRODUCTOS</h1>
    <form on:submit|preventDefault={validar}>


        <input type="number" bind:value={precio} required placeholder="PRECIO DEL PRODUCTO"/>
        <input type="text" bind:value={url} required placeholder="RUTA DE LA IMAGEN"/>
        <input type="text" bind:value={descripcion} required placeholder="DESCRIPCIÓN DEL PRODUCTO"/>
        <input type="text" bind:value={name} required placeholder="NOMBRE DEL PRODUCTO"/>
        {#if error}
            <p>datos incorrectos</p>
        {/if}
        <button type="submit">Enviar</button>
    </form>
</div>

<style>

    div {
        max-width: 100%;
        height:100vh;

        border: 1px solid black;
        display: flex;
        flex-direction: column;
    }


    h1 {

        text-align: center;
    }


    button {
        width: 200px;

        border-radius: 7px;
        background-color: #18a0fb;
        color: white;

        text-align: center;
    }

    input {
        width: 500px;


        border-radius: 3px;

    }

    form {
        display: flex;
        flex-direction: row;
        align-items: center;

    }
    p{
        color: red;
    }

</style>