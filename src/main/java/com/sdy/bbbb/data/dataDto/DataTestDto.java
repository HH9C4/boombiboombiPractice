package com.sdy.bbbb.data.dataDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataTestDto {
    private Map<String, Integer> lastPopByHour;
    private Map<String, Integer> todayPopByHour;


}
