
<script>

    import {Link} from "svelte-routing";


</script>
<div>


        <button ><Link style={"color: white; text-decoration: none"} to="/new">New Product</Link></button>
         <Link style={"color: white; text-decoration: none"} to="/">products</Link>


</div>



<style>

    div {
        height: 50px;
        display: flex;
        justify-content: end;
        background-color: darkgrey;
        padding: 35px;
        align-items: center;

    }

    button{

        width: 100px;
        height: 50px;
        margin-left: 100px;
        border-radius: 10px;
        font-size: 15px;
        margin-right: 100px;
        background: lightgray;



    }



</style>