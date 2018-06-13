package com.xpo.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xpo.app.model.UrlDetails;

public class URLMapper implements RowMapper<UrlDetails> {
	
	@Override
	public UrlDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		UrlDetails url = new UrlDetails();
		
		url.setId(rs.getInt("ID"));
		url.setClient(rs.getString("CLIENT_ID"));
		url.setEnvironment(rs.getString("ENVIRONMENT"));
		url.setName(rs.getString("NAME"));
		url.setJobsHttpUrl(rs.getString("JOBS_HTTP_URL"));
		url.setWebHttpsUrl(rs.getString("WEB_HTTP_URL"));
		url.setWebHttpUrl(rs.getString("WEB_HTTPS_URL"));
		url.setUserFriendlyServiceUrl(rs.getString("UF_SRV_URL"));
		url.setUserFriendlyMCUrl(rs.getString("UF_MC_URL"));
		url.setUserFriendlyWebUrl(rs.getString("UF_WEB_URL"));
	
	return url;
	}

}
