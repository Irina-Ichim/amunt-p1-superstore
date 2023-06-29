<script>
    import ProductCard from "../components/ProductCard.svelte";
    import {products} from "../../store/products.js";
    import {navigate} from "svelte-routing";

    let productList = [];
    products.subscribe(value => productList = value);
    let discountPrice;



    function fetchDiscountedProducts() {
        fetch('/api/products/discounted')
            .then(response => response.json())
            .then(data => {
                // Almacenar los datos en el store (suponiendo que ya has declarado "products" como una variable reactiva)
                products = data;

                // Navegar al catálogo con los datos actualizados
                navigate('/');
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }

</script>


<section>
    {#each productList as data}
        <ProductCard {...data}/>
    {/each}
</section>

<style>
    section {
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
        padding: 50px;
        gap: 50px;
        background-color: #e3e6e6;
    }
</style>