<script>


    import {navigate} from "svelte-routing";
    let productos="";
    let error;
    let nombre = "";
    let precio = "";
    let descripcion = "";
    let url = "";
    let id = "";

    function cancelar() {
        navigate("/admin");
    }


    function crearID() {
        return crypto.randomUUID()
    }

    function crearProducto() {

        let info = {
            name: nombre,
            price: precio,
            description: descripcion,
            imageUrl: url,
            id: crearID()
        }

        fetch("/api/products", {method: "POST", body: JSON.stringify(info)})
            .then(response => response.json())
            .then(datos => productos = datos)

        alert("producto añadido")
    }



</script>

<div>
    <h1>CREAR PRODUCTOS</h1>
    <form on:submit|preventDefault={crearProducto}>

        <label>
            <p>Nombre:</p>
            <input type="text" bind:value={nombre} required/>
        </label>
        <label>
            <p>Precio:</p>
            <input type="number" bind:value={precio} required/>
        </label>
        <label>
            <p>Descripción:</p>
            <textarea type="text" bind:value={descripcion} required></textarea>
        </label>
        <label>
            <p>Imagen Url:</p>
            <input type="text" bind:value={url} required/>
        </label>

        {#if error}
            <p>datos incorrectos</p>
        {/if}
        <section>
            <button type="submit">Añadir</button>
            <button type="button" on:click={cancelar}>Cancelar</button>
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
        margin-bottom: 50px;
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


    section {
        display: flex;
        justify-content: space-around;
        gap: 10px;
    }

    textarea {
        width: 503px;
        height: 106px;
    }


</style>