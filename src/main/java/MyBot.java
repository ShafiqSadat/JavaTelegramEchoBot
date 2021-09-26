import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().hasText()){
            var messageText = update.getMessage().getText();
            var userId = update.getMessage().getFrom().getId();
            sendMessageText(messageText,userId);
        }
    }

    public void sendMessageText(String text, Long userId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(String.valueOf(userId));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getBotUsername() {
        return "AnaabMyBot";
    }

    @Override
    public String getBotToken() {
        return "2032522351:AAHReO0nMJHxwf_S7Of3Y8STf4MLrThpdsU";
    }

}
