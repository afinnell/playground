/*
 * Copyright (c) 2017 Nova Ordis LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.novaordis.playground.jboss.jndi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import java.util.Properties;

/**
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 2/7/17
 */
public class Main {

    // Constants -------------------------------------------------------------------------------------------------------

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    // Static ----------------------------------------------------------------------------------------------------------

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();

        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        Context root = new InitialContext(properties);

        NamingEnumeration<NameClassPair> e = root.list("");

        while(e.hasMore()) {

            NameClassPair b = e.next();
            Util.logNameClassPair(b);
        }


//        //
//        // recursively dump the content of the JNDI space
//        //
//
//        StringBuilder rendering =  new StringBuilder();
//        rendering.append("/");
//        descend(root, rendering, 1);
//        log.info("JNDI space rendering:\n" + rendering);
    }

    // Attributes ------------------------------------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------------------------------------------------

    // Public ----------------------------------------------------------------------------------------------------------

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

//    private static void descend(Context c, StringBuilder rendering, int depth) throws Exception {
//
//        rendering.append("\n");
//
//        String prefix = Util.getPrefix(depth);
//
//        NamingEnumeration<Binding> e = c.listBindings("");
//
//        while(e.hasMore()) {
//
//            Binding b = e.next();
//            Util.logNameClassPair(b);
//
//            rendering.append(prefix).append(b.getName());
//
//            Object o = b.getObject();
//
//            if (o instanceof Context) {
//
//                Context child = (Context)o;
//                String name = child.getNameInNamespace();
//                descend(child, rendering, depth + 1);
//            }
//        }
//
//    }

    // Inner classes ---------------------------------------------------------------------------------------------------

}
