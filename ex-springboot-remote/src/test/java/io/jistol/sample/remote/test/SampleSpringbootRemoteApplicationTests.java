package io.jistol.sample.remote.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class SampleSpringbootRemoteApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void rmiTest_bean() throws Exception
	{
		String url = "/rmi/bean";
		MvcResult result = mvc.perform(get(url).contentType(MediaType.TEXT_PLAIN)).andReturn();
		Assert.assertEquals("rmi Hello bean", result.getResponse().getContentAsString());
	}

	@Test
	public void rmiTest_service() throws Exception
	{
		String url = "/rmi/service";
		MvcResult result = mvc.perform(get(url).contentType(MediaType.TEXT_PLAIN)).andReturn();
		Assert.assertEquals("rmi Hello service", result.getResponse().getContentAsString());
	}

	@Test
	public void rmiTest_extend() throws Exception
	{
		String url = "/rmi/extend";
		MvcResult result = mvc.perform(get(url).contentType(MediaType.TEXT_PLAIN)).andReturn();
		Assert.assertEquals("rmi Hello extend", result.getResponse().getContentAsString());
	}

	@Test
	public void httpTest_bean() throws Exception
	{
		String url = "/http/bean";
		MvcResult result = mvc.perform(get(url).contentType(MediaType.TEXT_PLAIN)).andReturn();
		Assert.assertEquals("http Hello bean", result.getResponse().getContentAsString());
	}

	@Test
	public void httpTest_service() throws Exception
	{
		String url = "/http/service";
		MvcResult result = mvc.perform(get(url).contentType(MediaType.TEXT_PLAIN)).andReturn();
		Assert.assertEquals("http Hello service", result.getResponse().getContentAsString());
	}

	@Test
	public void httpTest_extend() throws Exception
	{
		String url = "/http/extend";
		MvcResult result = mvc.perform(get(url).contentType(MediaType.TEXT_PLAIN)).andReturn();
		Assert.assertEquals("http Hello extend", result.getResponse().getContentAsString());
	}
}
