/** @type {import('tailwindcss').Config} */
module.exports = {
    content: ["./src/**/*.{html,js,jsx,ts,tsx,css}"],
    theme: {
        extend: {
            fontFamily: {
                mono: ['Azeret Mono Variable', 'monospace'], // Add your custom font first, fallback to monospace
            },
        },
    },
    plugins: [],
};
