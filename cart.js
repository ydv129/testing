const cart = JSON.parse(localStorage.getItem('cart')) || [];
const cartItemsList = document.getElementById('cart-items');
const cartCount = document.getElementById('cart-count');
const cartTotal = document.getElementById('cart-total');
const checkoutBtn = document.getElementById('checkout');

function showToast(message) {
  const toast = document.getElementById('toast');
  toast.textContent = message;
  toast.classList.add('show');
  setTimeout(() => {
    toast.classList.remove('show');
  }, 2000);
}

function updateCart() {
  cartItemsList.innerHTML = '';
  cartCount.textContent = cart.length;
  let total = 0;
  cart.forEach((item, index) => {
    total += item.price;
    const li = document.createElement('li');
    li.innerHTML = `
      <span>${item.name} - $${item.price.toFixed(2)}</span>
      <button class="remove-btn" data-index="${index}">Remove</button>
    `;
    cartItemsList.appendChild(li);
  });
  cartTotal.textContent = `Total: $${total.toFixed(2)}`;
  localStorage.setItem('cart', JSON.stringify(cart));
}

cartItemsList.addEventListener('click', (e) => {
  if (e.target.classList.contains('remove-btn')) {
    const index = e.target.dataset.index;
    cart.splice(index, 1);
    updateCart();
    showToast('Item removed from cart');
  }
});

checkoutBtn.addEventListener('click', () => {
  if (cart.length === 0) {
    showToast('Your cart is empty!');
    return;
  }
  showToast(`Thank you for your purchase! Total: $${cart.reduce((sum, item) => sum + item.price, 0).toFixed(2)}`);
  cart.length = 0;
  updateCart();
});

updateCart();