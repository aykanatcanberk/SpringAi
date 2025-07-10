package com.ai.SpringAi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatModel chatModel;

    public String getResponse(String prompt) {

        return chatModel.call(prompt);
    }

    public String getResponseOptions(String prompt) {
        ChatResponse response= chatModel.call(new Prompt(
                prompt,
                OpenAiChatOptions.builder()
                        //.model("gpt-4o")
                        .temperature(0.4)
                        .maxTokens(300)
                        .topP(0.9)
                        .presencePenalty(0.5)
                        .frequencyPenalty(0.2)
                        .build()));

        return response.getResult().getOutput().getText();
    }

}
