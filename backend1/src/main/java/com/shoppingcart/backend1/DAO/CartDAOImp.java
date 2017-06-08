/*package com.shoppingcart.backend1.DAO;

import org.springframework.stereotype.Repository;

public class CartDAOImp {

	@Repository
	public class CartDAOImp implements CartDAO {

		private final Logger logger = LoggerFactory.getLogger(CartDAOImp.class);

		@Autowired
		private SessionFactory sessionFactory;

		@Override
		public List<Cart> getCartList(String username) {
			logger.info("Starting getCartList method in cartDao");
			try {
				Query query = sessionFactory.getCurrentSession()
						.createQuery("from Cart where username = '" + username + "' and status='NEW'");
				return query.list();
			} catch (Exception e) {
				logger.error("Exception occured" + e);
				throw e;
			}
		}

		@Override
		public boolean save(Cart cart) {
			logger.info("Starting save method of cartdaoimpl");
			try {
				sessionFactory.getCurrentSession().save(cart);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception occured" + e);
				throw e;
			}
		}

		@Override
		public boolean delete(int id) {
			logger.info("Starting delete method of cartdaoimpl");
			try {
				sessionFactory.getCurrentSession().delete(getCartById(id));
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception occured" + e);
				throw e;
			}
		}

		@Override
		public boolean update(Cart cart) {
			logger.info("Starting update method in cartDao");
			try {
				sessionFactory.getCurrentSession().update(cart);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception occured" + e);
				throw e;
			}
		}

		@Override
		public long getTotalAmount(String username) {
			logger.info("Starting getTotalAmount method in cartDao");
			try {
				Query query = sessionFactory.getCurrentSession().createQuery(
						"SELECT SUM(price*quantity) FROM Cart where username='" + username + "' and status = 'NEW'");
				if (query.uniqueResult() == null) {
					return 0;
				} else {
					long result = (long) query.uniqueResult();
					return result;
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception occured" + e);
				throw e;
			}
		}

		@Override
		public Cart getCartByUsername(String username, String productname) {
			try {
				logger.info("Starting getcartbyusername method of cartdaoimpl");

				Query query = sessionFactory.getCurrentSession().createQuery("from Cart WHERE username='" + username
						+ "' and product_name='" + productname + "' and status = 'NEW'");
				logger.info("Ending getcartbyusername method of cartdaoimpl");
				return (Cart) query.uniqueResult();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception occured" + e);
				throw e;
			}
		}

		@Override
		public int getQuantity(String username, String productname) {
			try {
				logger.info("Starting getquantity method of cartdaoimpl");

				Query query = sessionFactory.getCurrentSession().createQuery("SELECT  quantity from Cart WHERE username='"
						+ username + "' and product_name='" + productname + "' and status = 'NEW'");
				logger.info("Ending getquantity method of cartdaoimpl");
				return (int) query.uniqueResult();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception occured" + e);
				throw e;
			}
		}

		@Override
		public long getNumberOfProducts(String username) {
			logger.info("Starting getNumberOfProducts method in cartDao");
			try {
				Query query = sessionFactory.getCurrentSession()
						.createQuery("SELECT SUM(quantity) FROM Cart where username='" + username + "' and status = 'NEW'");
				if (query.uniqueResult() == null) {
					return 0;
				} else {
					long result = (long) query.uniqueResult();
					return result;
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception occured" + e);
				throw e;
			}
		}

		@Override
		public Cart getCartById(int id) {
			logger.info("Starting getCartById method in cartDao");
			try {
				return sessionFactory.getCurrentSession().get(Cart.class, id);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception occured" + e);
				throw e;
			}
		}

		@Override
		public int clearCart(String username) {
			logger.info("Starting clearCart method in cartDao");
			try {
				
				 * Query query = sessionFactory.getCurrentSession()
				 * .createQuery("UPDATE Cart SET status='OLD' where username = '" +
				 * username + "'");
				 
				Query query = sessionFactory.getCurrentSession()
						.createQuery("DELETE from Cart where username = '" + username + "'");
				return query.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception occured" + e);
				throw e;
			}
		}

		public Cart validate(int cartId) throws IOException {
			logger.info("Starting validate method in cartDao");
			Cart cart = getCartById(cartId);
			if (cart == null) {
				throw new IOException(cartId + "");
			}
			update(cart);
			return cart;
		}

	}

}
*/