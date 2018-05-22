package com.rogercw;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by 1 on 2018/5/12.
 */
public class HibernateSessionFactory {

    // 会话工厂，整个程序只有一份。
    private static SessionFactory factory;

        static{
            //1 加载配置
            Configuration config = new Configuration().configure();

            //2 获得工厂
            factory = config.buildSessionFactory();
            //3 关闭虚拟机时,释放SessionFactory
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println("虚拟机关闭!释放资源");
                    factory.close();
                }
            }));
        }


        /**
         * 获得一个新的session
         * @return
         */
        public static Session openSession(){
            return factory.openSession();
        }

        /**
         * 获得当前线程中绑定session
         * * 注意：必须配置
         * @return
         */

        public static Session getCurrentSession(){
            return factory.getCurrentSession();
        }

}
