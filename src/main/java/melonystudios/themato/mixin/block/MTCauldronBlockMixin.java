package melonystudios.themato.mixin.block;

// @Mixin(CauldronBlock.class)
public class MTCauldronBlockMixin {
    /*@Unique
    private final Map<Item, CauldronInteraction> interactionMap;
    @Unique
    private static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_CAULDRON;

    public MTCauldronBlockMixin(Properties properties) {
        super(properties);
        this.interactionMap = CauldronInteraction.EMPTY;
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, 0));
    }

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    public void use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hitResult, CallbackInfoReturnable<ActionResultType> cir) {
        AbstractCauldronBlock cauldronBlock = (AbstractCauldronBlock) state.getBlock();
        ItemStack handStack = player.getItemInHand(hand);
        CauldronInteraction interaction = cauldronBlock.interactionMap.get(handStack.getItem());
        cir.setReturnValue(interaction.interact(state, world, pos, player, hand, handStack));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
    }*/
}
