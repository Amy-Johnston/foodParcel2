package com.foodparcel.Service.impl;

import com.foodparcel.Service.JobService;
import com.foodparcel.entity.Job;
import com.foodparcel.factory.JobFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JobServiceImplTest {

    private static JobService jobService = JobServiceImpl.getJobService();
    private static Job job = JobFactory.createJob("Accountantt");

    @Test
    public void d_getAll() {
        Assert.assertNotNull(jobService);
        System.out.println("Get all: " + jobService.getAll());
    }

    @Test
    public void a_create() {
        Job jobCreated = jobService.create(job);
        Assert.assertSame(job.getJobTitle(), jobCreated.getJobTitle());
        System.out.println("Create: " + jobCreated);
    }

    @Test
    public void b_read() {
        Job jobRead = jobService.read(job.getJobTitle());
        Assert.assertNotNull(jobRead);
        System.out.println("Read: " +jobRead);
    }

    @Test
    public void c_update() {
        Job jobUpdate = new Job.JobBuilder().copy(job).setJobTitle("Accountant").build();
        jobUpdate = jobService.update(jobUpdate);
        Assert.assertNotEquals(job , jobUpdate);
        System.out.println("Updated: " +jobUpdate);
    }

    @Test
    public void e_delete() {
        jobService.delete(job.getJobTitle());
        Assert.assertNotNull(job);
        System.out.println("Deleted: " + jobService.getAll());
    }
}