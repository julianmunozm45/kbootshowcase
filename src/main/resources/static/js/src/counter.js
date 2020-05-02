$('document').ready(() => {
    $('#categoriesList').on('change', () => {
        const category = $('#categoriesList option:selected').val();
        loadProducts(category);
    });
})

const loadProducts = (category) => {
    let url = '/filter?categoryId=' + category;
    console.log('filter - ', url);
    $.ajax({
        type: 'get',
        url: url,
        success: (data) => {
            $('#productsList').html(data);
        },
    })
}

const onCheckOut = () => {
    const category = $('#categoriesList option:checked').val();
    const url = `/check-out?categoryId=${category}`;
    console.log('checkout - ', url);
    $('#total').load(url);
};