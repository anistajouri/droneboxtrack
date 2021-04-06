package com.sofrecom.droneboxtracker.bookingms.infrastructure.config;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.common.jpa.SimpleEntityManagerProvider;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.xml.CompactDriver;
import org.axonframework.serialization.xml.XStreamSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import com.thoughtworks.xstream.converters.Converter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.Collection;

@Configuration
public class XStreamAutoConfiguration  {
/*
    org.axonframework.serialization.Converter x;

    @Bean
  //  @ConditionalOnMissingBean(XStream.class)
    public XStream xStream() {
        XStream xstream = new XStream();
        // clear out existing permissions and set own ones
        xstream.addPermission(NoTypePermission.NONE);
        // allow some basics
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.allowTypeHierarchy(Collection.class);
   //     XStream.setupDefaultSecurity(xstream);
        // allow any type from the same package
        xstream.allowTypesByWildcard(new String[] {
                "com.your.package.**"
        });
        return xstream;
    }


    @Bean
    public Collection<Converter> converters(XStream xstream, Collection<Converter> converters) {
        //converters.forEach(xstream::registerConverter());
        converters.forEach(converter -> xstream.registerConverter( converter));
        xstream.registerConverter((Converter) x);
        return converters;
    }*/
/*
    @Bean
    public EventStorageEngine eventStorageEngine(DataSource dataSource) throws SQLException {

        EntityManagerProvider entityManagerProvider = new SimpleEntityManagerProvider(entityManager);
        return new JpaEventStorageEngine(serializer(), NoOpEventUpcaster.INSTANCE, dataSource, entityManagerProvider, NoTransactionManager.INSTANCE);
    }

    private Object serializer() {
    }*/
/*    @Bean
    @ConditionalOnMissingBean(XStream.class)
    public XStream xStream() {
        return new XStream();
    }
    @Configuration
    public static class XStreamConverterAutoConfiguration {
        @Autowired
        private XStream xstream;
        @Autowired
        private Collection<Converter> converters;
        @PostConstruct
        public void registerConverters() {
            converters.forEach(converter -> xstream.registerConverter((com.thoughtworks.xstream.converters.Converter) converter));
        }
    }*/

/*    @Bean
    public Serializer serializer() {
        final XStream xStream = new XStream(new CompactDriver());
        xStream.setClassLoader(this.getClass().getClassLoader());
        final XStreamSerializer serializer = new XStreamSerializer(xStream);

        return serializer;
    }*/
}
