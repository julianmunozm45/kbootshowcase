$('document').ready(() => {
    $('#categoriesList').on('change', () => {
        const category = $('#categoriesList option:selected').val();
        loadProducts(category);
    });
})

const loadProducts = (category) => {
    let url = '/filter?categoryId=' + category;
    $.ajax({
        type: 'get',
        url: url,
        success: (data) => {
            console.log(data);
            $('#productsList').html(data);
        },
    })
}

const onCheckOut = () => {
    let url = '/check-out';
    console.log('url ', url);
    $('#total').load(url);
};