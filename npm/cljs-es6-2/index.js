import {enhanceValue} from "@delatrie-org/cljs-es6-1";

function enhanceValue2(v) {
    return enhanceValue(v) + ". I've came to talk to you again";
}

export { enhanceValue2 as enhanceValue };