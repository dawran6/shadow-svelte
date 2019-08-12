Inspired by Thomas Heller's https://github.com/thheller/next-cljs

Minimal example showing how shadow-cljs could be used together with [svelte](https://svelte.dev/) to create static sites in CLJS.

`site` is a directory used by `svelte`, all `.js` files will be generated by shadow-cljs. I nested the `site` directory in the `shadow-cljs` project but you can also nest the `shadow-cljs` directory in the next root instead. I do not recommend mixing though.

## Run shadow-cljs

```
npm install
# `shadow-cljs watch` is currently broken.
# npx shadow-cljs watch site
npx shadow-cljs release site
```

## Run svelte separately

```
cd site
npm install
npm run dev
```

## When done open in browser

```
open http://localhost:3000
```