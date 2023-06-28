<script>

    export let info;
    let precio = "";
    let descripcion = "";
    let url = "";
    let nombre = "";


    let error = false;

    function validar() {
        if (info.name === "manu") {
            alert("lo pilla")
        } else {
            error = true;
        }
    }

</script>
<div>
    <h1>CREAR PRODUCTOS</h1>
    <form on:submit|preventDefault={validar}>


        <input type="number" bind:value={precio} required placeholder="PRECIO DEL PRODUCTO"/>
        <input type="text" bind:value={url} required placeholder="RUTA DE LA IMAGEN"/>
        <input type="text" bind:value={descripcion} required placeholder="DESCRIPCIÓN DEL PRODUCTO"/>
        <input type="text" bind:value={nombre} required placeholder="NOMBRE DEL PRODUCTO"/>
        {#if error}
            <p>datos incorrectos</p>
        {/if}
        <section>
            <button type="submit">Añadir</button>
            <button>Cancelar</button>
        </section>
    </form>
</div>


<style>

    div {
        width: 100%;
        height: 50vh;
        display: flex;
        flex-direction: column;

    }


    h1 {

        text-align: center;
        margin-bottom: 80px;
    }


    button {
        width: 200px;

        border-radius: 7px;
        color: black;
        margin-top: 30px;
        text-align: center;
    }

    input {
        width: 500px;
        border-radius: 3px;

    }

    form {
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 5px;

    }

    p {
        color: red;
    }

    section {
        display: flex;
        justify-content: space-around;
        gap: 10px;
    }


</style>