<script>
    let shown = false;
    export function  show() {
        shown = true;
    }
    export function hide() {
        shown=false;
    }
</script>

<style>
    section {
        background-color: rgb(0, 0, 0, 0.6);
        position: fixed;
        width:100%;
        height:100%;
        top:0;
        left:0;
    }

    div{
        background-color: white;
        max-width: 80vw;
        padding: 1rem;
        margin: 15% auto;
    }
    </style>

    <main>
    {#if shown}
        <section>
            <div>
                <slot />
            </div>
        </section>
    {/if}
   </main>
