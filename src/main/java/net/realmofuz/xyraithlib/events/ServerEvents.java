package net.realmofuz.xyraithlib.events;

public interface ServerEvents {
    void serverStart();
    void serverStop();
    void playerJoin(EventMeta event);
    void playerLeave(EventMeta event);
    void playerLeftClick(EventMeta event);
    void playerRightClick(EventMeta event);
    void playerSwapHands(EventMeta event);
    void playerPickupItem(EventMeta event);
    void playerConsumeItem(EventMeta event);

    void playerClickEntity(EventMeta event);
    void playerQuit(EventMeta event);
    void playerPreprocessCommand(EventMeta event);


}
