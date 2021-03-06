/*
 * This software was developed at the National Institute of Standards and
 * Technology by employees of the Federal Government in the course of
 * their official duties. Pursuant to title 17 Section 105 of the United
 * States Code this software is not subject to copyright protection and is
 * in the public domain. This software is an experimental system. NIST assumes
 * no responsibility whatsoever for its use by other parties, and makes no
 * guarantees, expressed or implied, about its quality, reliability, or
 * any other characteristic. We would appreciate acknowledgement if the
 * software is used.
 */
package gov.nist.itl.ssd.wipp.backend.data.pyramidannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import gov.nist.itl.ssd.wipp.backend.core.rest.PaginationParameterTemplatesHelper;
import gov.nist.itl.ssd.wipp.backend.data.pyramidannotation.timeslices.PyramidAnnotationTimeSliceController;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

/**
 * @author Mohamed Ouladi <mohamed.ouladi at nist.gov>
 */
@Component
public class PyramidAnnotationResourceProcessor implements RepresentationModelProcessor<EntityModel<PyramidAnnotation>> {

    @Autowired
    private PaginationParameterTemplatesHelper assembler;

    @Override
    public EntityModel<PyramidAnnotation> process(
            EntityModel<PyramidAnnotation> resource) {
    	PyramidAnnotation annotation = resource.getContent();

        Link link = WebMvcLinkBuilder.linkTo(
                PyramidAnnotationTimeSliceController.class, annotation.getId())
                .withRel("timeSlices");
        resource.add(assembler.appendPaginationParameterTemplates(link));

        return resource;
    }

}
