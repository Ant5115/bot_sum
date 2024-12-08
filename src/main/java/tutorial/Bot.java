package tutorial;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    List<String> messages = new ArrayList<String>();

    public String getBotUsername() {
        return "TutorialBot";
    }

    @Override
    public String getBotToken() {
        return "7641801953:AAFNbzraA6O41AZPCdscuQQiSLdl--ZKAfs";
    }


    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        String message = msg.getText();//сообщение пользователя
        User user = msg.getFrom(); //сам пользователь
        Long id = user.getId(); // id пользователя
        String userName = user.getUserName(); //юзернейм пользователя

        //это ответ бота
        String answer = "";


//        if (message.equalsIgnoreCase("/last")){
//            answer = messages.get(messages.size()-1);
//        } else {
//            answer = "Сообщение сохранено";
//            messages.add(message);
//        }

        // /show
//        if (message.equalsIgnoreCase("/show")){
//            answer = messages.get(0) + " " + messages.get(1);
//        } else {
//            messages.add(message);
//        }


        // /count
        // всего введено сообщений:
//        if (message.equalsIgnoreCase("/count")) {
//            answer = String.valueOf(messages.size());
//        }else {
//            messages.add(message);
//        }

        //  /sum
        // сумму 1 и 2 введенных чисел

        if (message.equalsIgnoreCase("/sum")) {
            answer = String.valueOf(Integer.parseInt(messages.get(0)) + Integer.parseInt(messages.get(1)));
        }else {
            messages.add(message);
        }

        //оставляем как есть
        SendMessage sm = SendMessage.builder()
                .chatId(id.toString())
                .text(answer) //что будет отвечать бот
                .build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


}
