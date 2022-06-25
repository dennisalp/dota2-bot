# Dota 2 Bot

Back in 2013, I wrote a bot in Java for the video game Dota 2. The bot even attracted attention on Reddit. Clearly, [just narrowly failing the Turing test](https://www.reddit.com/r/DotA2/comments/1ptytx/comment/cd6bgxk/?utm_source=share&utm_medium=web2x&context=3):

![bot_famous.png](https://dennisalp.com/assets/img/bot_famous.png)

It successfully played hundreds of games, which were also streamed on Twitch. This was before the Dota 2 API was provided, so designing the bot to interact as a human to circumvent any scripting filters added additional complexity to the problem. This and actually navigating menus and playing the game well enough to not be game-breaking were the goals, rather than being an amazing gamer.

It turned out to be quite high-maintenance because Valve (presumably) recompressed the graphics for the UI so each patch required an update of the bot, even though the UI didn't change visually. This would obviously be easy to avoid if I realized that this would be a problem up-front, but this would require a significant revision and major patches kept breaking things. However, it did successfully run, stream, and farm items for about 6 months.
