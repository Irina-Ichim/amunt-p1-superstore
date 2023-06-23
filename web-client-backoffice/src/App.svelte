<script>
    import {onMount} from "svelte";
    import Product from "./lib/components/Product.svelte";
    import Header from "./lib/components/Header.svelte";

    let productos = [];

    function cargarProductos() {
        fetch("http://localhost:8080/api/products")
            .then(response => response.json())
            .then(datos => productos = datos)
    }

    onMount(cargarProductos);

    let deleteProduct = (id) => {

        fetch(`/api/products/${id}`, {method: "DELETE"})
            .then(response => {
                if (response.ok) {
                    console.log(`borrado producto ${id}`);
                }
            })
            .then(cargarProductos)
    }

</script>

<main>
    <Header/>
    <div>
        {#each productos as producto}
            <Product info={producto} onDelete={deleteProduct}/>
        {/each}
    </div>

</main>

<style>
    div {
        margin: 40px 80px;
    }
</style>

