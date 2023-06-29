<script>
    import {navigate} from "svelte-routing";

    let info;
    let error;


    function cancelar() {
        navigate("/admin");
    }

    function crearProducto() {
        console.log(info);
    }

</script>
<div>
    <h1>CREAR PRODUCTOS</h1>
    <form on:submit|preventDefault={crearProducto}>

        <label for="name">Name:</label>
        <input id="name" type="text" bind:value={info.name}>
        <label for="price">Price:</label>
        <input id="price" type="text" bind:value={info.price}>
<!--        <input type="number" bind:value={info.price} required/>-->

<!--        <textarea bind:value={info.description} required></textarea>-->

<!-git-        <p>Imagen Url:</p>-->
<!--        <input type="text" bind:value={info.imageUrl} required/>-->


<!--        {#if error}-->
<!--            <p>datos incorrectos</p>-->
<!--        {/if}-->
<!--        <section>-->
<!--            <button type="submit">Añadir</button>-->
<!--            <button type="button" on:click={cancelar}>Cancelar</button>-->
<!--        </section>-->
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