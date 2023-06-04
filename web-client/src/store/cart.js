import {derived, writable} from "svelte/store";

export let cart = writable([]);

export let cartSize = derived(cart, $cart => $cart.length)
export let cartTotalCost = derived(cart,
    $cart =>
        $cart
            .map(p => p.price)
            .reduce((s, p) => s + p, 0)
)