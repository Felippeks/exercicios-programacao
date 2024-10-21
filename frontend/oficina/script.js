const SERVICES_KEY = 'services';
const DEFAULT_SERVICES = [
    { name: 'Troca de Óleo', price: 100 },
    { name: 'Alinhamento', price: 150 },
    { name: 'Revisão Completa', price: 300 },
    { name: 'Troca de pneu', price: 450 },
    { name: 'Geometria e balanceamento', price: 100}
];

window.onload = function() {
    if (!localStorage.getItem(SERVICES_KEY)) {
        localStorage.setItem(SERVICES_KEY, JSON.stringify(DEFAULT_SERVICES));
    }
    loadServices();
    
    document.getElementById('service-update-form').addEventListener('submit', updatePrice);
    document.getElementById('contact-form').addEventListener('submit', submitContactForm);
};

function loadServices() {
    let services = JSON.parse(localStorage.getItem(SERVICES_KEY)) || [];
    let servicesDiv = document.getElementById('services');
    servicesDiv.innerHTML = '';
    services.forEach(service => {
        let serviceDiv = document.createElement('div');
        serviceDiv.textContent = `${service.name}: ${service.price}`;
        servicesDiv.appendChild(serviceDiv);
    });
}

function updatePrice(event) {
    event.preventDefault();

    let name = document.getElementById('service-name').value;
    let price = document.getElementById('service-price').value;
    
    let services = JSON.parse(localStorage.getItem(SERVICES_KEY)) || [];
    let service = services.find(service => service.name === name);
    if (service) {
        service.price = price;
    } else {
        services.push({ name, price });
    }
    localStorage.setItem(SERVICES_KEY, JSON.stringify(services));
    
    loadServices();
}

function submitContactForm(event) {
    event.preventDefault();

    let name = document.getElementById('contact-name').value;
    let email = document.getElementById('contact-email').value;
    let message = document.getElementById('contact-message').value;

    console.log('Enviar email:', name, email, message);

    document.getElementById('contact-name').value = '';
    document.getElementById('contact-email').value = '';
    document.getElementById('contact-message').value = '';
}
