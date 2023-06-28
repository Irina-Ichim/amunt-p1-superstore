<script>
    import {onMount} from 'svelte';
    import {navigate} from "svelte-routing";


    let discountPrice = () => {
        navigate(`/products/{discountPrice}`);
    }

    onMount(() => {
        fetch("http://localhost:8080/products")
            .then((respuesta) => respuesta.json())
            .then((datos) => (discountPrice) = datos)
    })

</script>

<h1>Ofertas</h1>

{#if discountPrice.length > null}
    {#each discountPrice as producto}
        <div>
            <h3>{producto.name}</h3>
            <p>Precio: {producto.price}</p>
            <p>Precio con descuento: {producto.discountPrice}</p>
        </div>
    {/each}
{:else}
    <p>No hay productos en oferta en este momento.</p>
{/if}
