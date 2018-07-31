package com.ishioka.ecsitetest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ishioka.ecsitetest.dto.DestinationInfoDTO;
import com.ishioka.ecsitetest.util.DBConnector;

public class DestinationInfoDAO {

	public int insert(String userId, String familyName, String firstName, String familyNameKana, String firstNameKana,
		String email, String telNumber, String userAddress) {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		int count = 0;

		//宛先情報をdestination_infoに登録
		String sql = "insert into destination_info(user_id, family_name, first_name, family_name_kana, first_name_kana, email, tel_number, user_address, regist_date, update_date)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, now(), now())";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, familyName);
			preparedStatement.setString(3, firstName);
			preparedStatement.setString(4, familyNameKana);
			preparedStatement.setString(5, firstNameKana);
			preparedStatement.setString(6, email);
			preparedStatement.setString(7, telNumber);
			preparedStatement.setString(8, userAddress);
			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<DestinationInfoDTO> getDestinationInfo(String loginId) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();

		String sql = "SELECT id, family_name, first_name, family_name_kana, first_name_kana, user_address, tel_number, email FROM destination_info WHERE user_id = ?";

		try {
			connection = dbConnector.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				DestinationInfoDTO destinationInfoDTO = new DestinationInfoDTO();
				destinationInfoDTO.setId(resultSet.getInt("id"));
				destinationInfoDTO.setFamilyName(resultSet.getString("family_name"));
				destinationInfoDTO.setFirstName(resultSet.getString("first_name"));
				destinationInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				destinationInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
				destinationInfoDTO.setUserAddress(resultSet.getString("user_address"));
				destinationInfoDTO.setEmail(resultSet.getString("email"));
				destinationInfoDTO.setTelNumber(resultSet.getString("tel_number"));
				destinationInfoDtoList.add(destinationInfoDTO);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return destinationInfoDtoList;
	}
}
