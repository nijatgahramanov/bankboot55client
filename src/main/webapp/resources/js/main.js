$(function (){
    $('#addBtnId').click(function (){
        addCustomer();
    });
});

function addCustomer(){
    let username = $('#usernameId').val()
    let password = $('#passwordId').val()
    let name = $('#nameId').val()
    let surname = $('#surnameId').val()
    let dob = $('#dobId').val()
    let address = $('#addressId').val()
    let phone = $('#phoneId').val()
    let cif = $('#cifId').val()
    let pin = $('#pinId').val()
    let seria = $('#seriaId').val()

    let data = {
        username: username,
        password: password,
        name: name,
        surname: surname,
        dob: dob,
        address: address,
        phone: phone,
        cif: cif,
        pin: pin,
        seria: seria
    };

    $.ajax({
        url: '/addCustomer',
        type: 'POST',
        data: JSON.stringify(data),
        dataType: 'text',
        headers: {
            'Content-type' : 'application/json',

        },
        success: function (response){
            if(response=='success'){
                alert('Added is success!')
            }else{
                alert('Added is fail')
                window.location = 'http://localhost:8084/client/getCustomerList';
            }
        }
    })

}