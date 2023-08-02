package jpabook;

import com.sun.org.apache.xpath.internal.operations.Or;
import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //이거 시작 해줘야함!
        tx.begin();

        try{
            Order order = em.find(Order.class, 1L);
//            Long memberId = order.getMemberId();

//            Order order = new Order();
            //양방향 연관관계 세팅
//            order.addOrderItem(new OrderItem());

            //양방향 세팅 안하고 이렇게 해도됨
//            em.persist(order);
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//            em.persist(orderItem);


            ///상속
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김다혜");
            em.persist(book);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
    }
}