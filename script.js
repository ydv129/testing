const cart = JSON.parse(localStorage.getItem('cart')) || [];
const cartCount = document.getElementById('cart-count');
const productGrid = document.querySelector('.product-grid');

// Toast notification
function showToast(message) {
  const toast = document.getElementById('toast');
  toast.textContent = message;
  toast.classList.add('show');
  setTimeout(() => {
    toast.classList.remove('show');
  }, 2000);
}

// Add to cart using event delegation
productGrid.addEventListener('click', (e) => {
  if (e.target.tagName === 'BUTTON' && e.target.textContent === 'Add to Cart') {
    const productCard = e.target.closest('.product-card');
    const productName = productCard.querySelector('h3').textContent;
    const productPrice = parseFloat(productCard.querySelector('p').textContent.replace('$', ''));
    cart.push({ name: productName, price: productPrice });
    updateCart();
    showToast(`${productName} added to cart!`);
  }
});

// Update cart display
function updateCart() {
  cartCount.textContent = cart.length;
  localStorage.setItem('cart', JSON.stringify(cart));
}

// Search feature
const searchInput = document.getElementById('search-input');
const searchBtn = document.getElementById('search-btn');
const productCards = Array.from(document.querySelectorAll('.product-card'));

function filterProducts() {
  const query = searchInput.value.trim().toLowerCase();
  productCards.forEach(card => {
    const name = card.querySelector('h3').textContent.toLowerCase();
    if (name.includes(query)) {
      card.style.display = '';
    } else {
      card.style.display = 'none';
    }
  });
}

searchInput.addEventListener('input', filterProducts);
searchBtn.addEventListener('click', filterProducts);

// Initialize cart display
updateCart();
