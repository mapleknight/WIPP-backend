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
package gov.nist.itl.ssd.wipp.backend.core.model.job;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import gov.nist.itl.ssd.wipp.backend.core.model.computation.WippExecutable;
import gov.nist.itl.ssd.wipp.backend.core.model.job.JobStatus;
import gov.nist.itl.ssd.wipp.backend.core.model.workflow.WippWorkflow;
import gov.nist.itl.ssd.wipp.backend.core.rest.annotation.IdExposed;
import gov.nist.itl.ssd.wipp.backend.core.rest.annotation.ManualRef;
import gov.nist.itl.ssd.wipp.backend.core.rest.annotation.Updatable;

/**
 *
 * @author Antoine Vandecreme <antoine.vandecreme at nist.gov>
 */
@IdExposed
@Document(collection = "job")
public abstract class WippJob {

    @Id
    private String id;

    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date creationDate;

    @Updatable
    private JobStatus status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date startTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date endTime;

    private String error;
    
    private WippExecutable executable;
    
    @ManualRef(value = WippWorkflow.class)
    private String wippWorkflow;
    
    private String wippVersion;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getType() {
        String type = this.getClass().getSimpleName();
        return type.substring(0, 1).toLowerCase() + type.substring(1);
    }

	public WippExecutable getExecutable() {
		return executable;
	}

	public void setExecutable(WippExecutable executable) {
		this.executable = executable;
	}

	public String getWippWorkflow() {
		return wippWorkflow;
	}

	public void setWippWorkflow(String wippWorkflow) {
		this.wippWorkflow = wippWorkflow;
	}

	public String getWippVersion() {
		return wippVersion;
	}

	public void setWippVersion(String wippVersion) {
		this.wippVersion = wippVersion;
	}

}