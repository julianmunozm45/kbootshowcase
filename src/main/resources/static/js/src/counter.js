function onCheckOut() {
    let url = '/check-out';
    console.log('url ', url);
    $('#total').load(url);
}